package com.bstek.dorado.sample.standardlesson.service;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.springframework.stereotype.Component;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.core.DoradoAbout;
@Component
public class  SystemInfoService {
    @Expose
    public Properties getSystemInfo() {
        Properties info = new Properties();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ hh:mm:ss");
        info.setProperty("product", DoradoAbout.getProductTitle());
        info.setProperty("vendor", DoradoAbout.getVendor());
        info.setProperty("version", DoradoAbout.getVersion());
        info.setProperty("time", sdf.format(new Date()));
        return info;
    }
}