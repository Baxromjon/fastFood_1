package ai.fl.demofoods.controller;


import ai.fl.demofoods.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attachment")
@CrossOrigin
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/save")
    public HttpEntity<?> uploadFile(MultipartHttpServletRequest request){
        UUID uuid=attachmentService.uploadFile(request);
        return ResponseEntity.ok(uuid);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getFile(@PathVariable UUID id){
        return attachmentService.getFile(id);
    }

    @GetMapping("/getAll")
    public List<?> getAll(){
        return attachmentService.getAll();
    }
}
