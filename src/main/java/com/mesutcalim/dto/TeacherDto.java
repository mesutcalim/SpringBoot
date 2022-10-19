package com.mesutcalim.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDto {
    private Long teacherId;
    @NotEmpty(message = "Ad soyad alanını boş geçemezsiniz")
    @Size(min = 1,max = 255)
    private String teacherNameSurname;
    @NotEmpty(message = "Email alanını boş geçemezsiniz")
    @Email(message = "uygun formatta mail girmediniz")
    private String teacherEmail;
    @NotEmpty(message = "Şifre alanını boş geçemezsiniz")
    private String teacherPassword;
}
