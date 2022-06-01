package ai.fl.demofoods.service;


import ai.fl.demofoods.security.ResourceNotFoundException;
import ai.fl.demofoods.entity.Attachment;
import ai.fl.demofoods.entity.AttachmentContent;
import ai.fl.demofoods.repository.AttachmentContentRepository;
import ai.fl.demofoods.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public UUID uploadFile(MultipartHttpServletRequest request) {
        try {
            MultipartFile file = request.getFile("file");
            assert file != null;
            Attachment attachment = attachmentRepository.save(new Attachment(
                            file.getName(), file.getSize(), file.getContentType()
                    ));
            try {
                attachmentContentRepository.save( new AttachmentContent(
                        attachment, file.getBytes()
                ));
            }catch (IOException e){
                e.printStackTrace();
            }
            return attachment.getId();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public HttpEntity<?> getFile(UUID id){
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("attachment", "id", id));
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(id).orElseThrow(() -> new ResourceNotFoundException("attachmentContent", "attachmentId", id));
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\""+attachment.getName()+"\"")
                .body(attachmentContent.getContent());
    }

    public List<?> getAll() {
        return attachmentRepository.findAll();
    }
}
