package com.lays.sampleactivemq;

public class SampleChatMessage {

    private Long scope;
    private String who;
    private String what;
    private Long when;

    public Long getScope() {
        return scope;
    }
    public void setScope(Long scope) {
        this.scope = scope;
    }
    public String getWho() {
        return who;
    }
    public void setWho(String who) {
        this.who = who;
    }
    public String getWhat() {
        return what;
    }
    public void setWhat(String what) {
        this.what = what;
    }
    public Long getWhen() {
        return when;
    }
    public void setWhen(Long when) {
        this.when = when;
    }

    public SampleChatMessage() { }

    @Override
    public String toString() {
        return String.format(
                "SampleChatMsg[who=%s, what=%s, when=%s, scope=%d]",
                who, what, Utils.asReadableDatetime(when), scope
        );
    }
}
