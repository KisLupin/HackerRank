public class Snippet {
    private String channelId;
    private String videoId;
    private TopLevelComment topLevelComment;
    private boolean canReply;
    private int totalReplyCount;
    private boolean isPublic;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public TopLevelComment getTopLevelComment() {
        return topLevelComment;
    }

    public void setTopLevelComment(TopLevelComment topLevelComment) {
        this.topLevelComment = topLevelComment;
    }

    public boolean isCanReply() {
        return canReply;
    }

    public void setCanReply(boolean canReply) {
        this.canReply = canReply;
    }

    public int getTotalReplyCount() {
        return totalReplyCount;
    }

    public void setTotalReplyCount(int totalReplyCount) {
        this.totalReplyCount = totalReplyCount;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
