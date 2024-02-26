package cn.giseryung.mybatisstudy.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class CMSException extends RuntimeException {
    private String errInfo;

}
