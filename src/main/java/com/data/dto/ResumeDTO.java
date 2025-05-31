package com.data.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ResumeDTO {
    private long id;
    @NotBlank(message = "Tên không để trống!")
    private String fullName;
    @NotBlank(message = "Email không để trống!")
    @Email(message = "Email không hợp lệ!")
    private String email;
    @NotBlank(message = "Số điện thoại không để trống!")
    @Pattern(regexp = "^(0[0-9]{9})$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;
    @NotBlank(message = "Trình độ học vấn không để trống!")
    private String education;
    @NotBlank(message = "Kinh nghiệm làm việc không để trống!")
    private String experience;
    @NotBlank(message = "Kỹ năng không để trống!")
    private String skills;
}
