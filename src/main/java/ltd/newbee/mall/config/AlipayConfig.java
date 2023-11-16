package ltd.newbee.mall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

///@ConfigurationProperties - 表示这个类中的属性可以通过配置文件进行注入。prefix指定了配置的前缀。
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {

    private String appId;
    private String rsaPrivateKey;
    private String alipayPublicKey;
    private String gateway;
    private String charset;
    private String format;
    private String logPath;
    private String signtype;

    public String getAppId() {
        return appId;
    }

    public AlipayConfig setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public AlipayConfig setRsaPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
        return this;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public AlipayConfig setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
        return this;
    }

    public String getGateway() {
        return gateway;
    }

    public AlipayConfig setGateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public AlipayConfig setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public AlipayConfig setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getLogPath() {
        return logPath;
    }

    public AlipayConfig setLogPath(String logPath) {
        this.logPath = logPath;
        return this;
    }

    public String getSigntype() {
        return signtype;
    }

    public AlipayConfig setSigntype(String signtype) {
        this.signtype = signtype;
        return this;
    }
}
