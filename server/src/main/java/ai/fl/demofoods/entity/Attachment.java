package ai.fl.demofoods.entity;

import ai.fl.demofoods.entity.template.AbsEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * created by Baxromjon
 * 04.02.2022
 **/


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment extends AbsEntity {
    private String name;
    private long size;
    private String contentType;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "attachment",cascade = CascadeType.ALL)
    private AttachmentContent attachmentContent;

    public Attachment(String name, long size, String contentType) {
        this.name = name;
        this.size = size;
        this.contentType = contentType;
    }
}
