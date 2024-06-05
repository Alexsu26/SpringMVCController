package com.liyang.mvccontroller.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Transaction {

    @NotNull
    private Long productId;

    @NotNull
    private Long userId;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    @NotNull
    @DecimalMin(value = "0.1")
    private Double price;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer quantity;

    @NotNull
    @DecimalMin("1.00")
    @DecimalMax("50000.00")
    private Double amount;

    @Pattern(
            regexp = "^[a-zA-z0-9]*[-_]?[a-zA-z0-9]+)*@"
            + "([a-zA-z0-9]*[-_]?[a-zA-z0-9]+)+"
            + "[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?",
            message = "不符合邮件格式")
    private String email;

    @Size(min = 0, max = 256)
    private String note;

    public @NotNull Long getProductId() {
        return productId;
    }

    public void setProductId(@NotNull Long productId) {
        this.productId = productId;
    }

    public @NotNull Long getUserId() {
        return userId;
    }

    public void setUserId(@NotNull Long userId) {
        this.userId = userId;
    }

    public @Future @NotNull Date getDate() {
        return date;
    }

    public void setDate(@Future @NotNull Date date) {
        this.date = date;
    }

    public @NotNull @DecimalMin(value = "0.1") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull @DecimalMin(value = "0.1") Double price) {
        this.price = price;
    }

    public @NotNull @Min(1) @Max(100) Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull @Min(1) @Max(100) Integer quantity) {
        this.quantity = quantity;
    }

    public @NotNull @DecimalMin("1.00") @DecimalMax("50000.00") Double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull @DecimalMin("1.00") @DecimalMax("50000.00") Double amount) {
        this.amount = amount;
    }

    public @Pattern(
            regexp = "^[a-zA-z0-9]*[-_]?[a-zA-z0-9]+)*@"
                    + "([a-zA-z0-9]*[-_]?[a-zA-z0-9]+)+"
                    + "[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?",
            message = "不符合邮件格式") String getEmail() {
        return email;
    }

    public void setEmail(@Pattern(
            regexp = "^[a-zA-z0-9]*[-_]?[a-zA-z0-9]+)*@"
                    + "([a-zA-z0-9]*[-_]?[a-zA-z0-9]+)+"
                    + "[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?",
            message = "不符合邮件格式") String email) {
        this.email = email;
    }

    public @Size(min = 0, max = 256) String getNote() {
        return note;
    }

    public void setNote(@Size(min = 0, max = 256) String note) {
        this.note = note;
    }
}
