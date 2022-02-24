package com.cyn.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * AICC初始化的参数
 *
 * @author ynchen9
 */
@Component
@RefreshScope
public class SysInitParam {
    @Value("${webphone.ws}")
    private String webPhoneWs;
    @Value("${cbb.Web.Url:}")
    private String cbbWebUrl;
    @Value("${msg.Web.Url:}")
    private String msgWebUrl;
    @Value("${flow.Web.Url:}")
    private String flowWebUrl;
    @Value("${repo.Web.Url:}")
    private String repoWebUrl;
    @Value("${rz.web.url:}")
    private String rzWebUrl;
    @Value("${im.Web.Url:}")
    private String imWebUrl;
    @Value("${signalTimeOut}")
    private String signalTimeOut;
    @Value("${cbb.embed:false}")
    private boolean cbbEmbed;
    @Value("${msg.embed:false}")
    private boolean msgEmbed;
    @Value("${flow.embed:false}")
    private boolean flowEmbed;
    @Value("${rz.embed:false}")
    private boolean rzEmbed;
    @Value("${im.embed:false}")
    private boolean imEmbed;

    public String getWebPhoneWs() {
        return webPhoneWs;
    }

    public void setWebPhoneWs(String webPhoneWs) {
        this.webPhoneWs = webPhoneWs;
    }

    public String getCbbWebUrl() {
        return cbbWebUrl;
    }

    public void setCbbWebUrl(String cbbWebUrl) {
        this.cbbWebUrl = cbbWebUrl;
    }

    public String getMsgWebUrl() {
        return msgWebUrl;
    }

    public void setMsgWebUrl(String msgWebUrl) {
        this.msgWebUrl = msgWebUrl;
    }

    public String getFlowWebUrl() {
        return flowWebUrl;
    }

    public void setFlowWebUrl(String flowWebUrl) {
        this.flowWebUrl = flowWebUrl;
    }

    public String getRepoWebUrl() {
        return repoWebUrl;
    }

    public void setRepoWebUrl(String repoWebUrl) {
        this.repoWebUrl = repoWebUrl;
    }

    public String getRzWebUrl() {
        return rzWebUrl;
    }

    public void setRzWebUrl(String rzWebUrl) {
        this.rzWebUrl = rzWebUrl;
    }

    public String getImWebUrl() {
        return imWebUrl;
    }

    public void setImWebUrl(String imWebUrl) {
        this.imWebUrl = imWebUrl;
    }

    public String getSignalTimeOut() {
        return signalTimeOut;
    }

    public void setSignalTimeOut(String signalTimeOut) {
        this.signalTimeOut = signalTimeOut;
    }

    public boolean isCbbEmbed() {
        return cbbEmbed;
    }

    public void setCbbEmbed(boolean cbbEmbed) {
        this.cbbEmbed = cbbEmbed;
    }

    public boolean isMsgEmbed() {
        return msgEmbed;
    }

    public void setMsgEmbed(boolean msgEmbed) {
        this.msgEmbed = msgEmbed;
    }

    public boolean isFlowEmbed() {
        return flowEmbed;
    }

    public void setFlowEmbed(boolean flowEmbed) {
        this.flowEmbed = flowEmbed;
    }

    public boolean isRzEmbed() {
        return rzEmbed;
    }

    public void setRzEmbed(boolean rzEmbed) {
        this.rzEmbed = rzEmbed;
    }

    public boolean isImEmbed() {
        return imEmbed;
    }

    public void setImEmbed(boolean imEmbed) {
        this.imEmbed = imEmbed;
    }

    @Override
    public String toString() {
        return "SysInitParam{" +
                "webPhoneWs='" + webPhoneWs + '\'' +
                ", cbbWebUrl='" + cbbWebUrl + '\'' +
                ", msgWebUrl='" + msgWebUrl + '\'' +
                ", flowWebUrl='" + flowWebUrl + '\'' +
                ", repoWebUrl='" + repoWebUrl + '\'' +
                ", rzWebUrl='" + rzWebUrl + '\'' +
                ", imWebUrl='" + imWebUrl + '\'' +
                ", signalTimeOut='" + signalTimeOut + '\'' +
                ", cbbEmbed=" + cbbEmbed +
                ", msgEmbed=" + msgEmbed +
                ", flowEmbed=" + flowEmbed +
                ", rzEmbed=" + rzEmbed +
                ", imEmbed=" + imEmbed +
                '}';
    }
}
