package rssfeedreader.habibqureshi.rssfeedreaeder;

/**
 * Created by HabibQureshi on 9/25/2017.
 */

public class gadgets360 {
    /*
    * This is the class to store data from rss
    * so we don't have to parse again and again
    *
    */
    public String tittle="tittle";
    public String link="link";
    public String updatedAt="updateAt";
    public String pubDate="pubDate";
    public String StoryImage="StoryImage";
    public String category="category";
    public String description="description";
    public void printData() {
        M.l("tittle="+this.tittle);
        M.l("link="+this.link);
        M.l("updatedAt="+this.updatedAt);
        M.l("pubDate="+this.pubDate);
        M.l("StoryImage="+this.StoryImage);
        M.l("category="+this.category);
        M.l("description="+this.description);


    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getStoryImage() {
        return StoryImage;
    }

    public void setStoryImage(String storyImage) {
        StoryImage = storyImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
