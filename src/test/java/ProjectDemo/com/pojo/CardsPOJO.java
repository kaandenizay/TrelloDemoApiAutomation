package ProjectDemo.com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardsPOJO {

    private String name;
    private String desc;
//    private int pos;
    private boolean isTemplate;

    public CardsPOJO() {
    }

    public CardsPOJO(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public CardsPOJO(String name, String desc, boolean isTemplate) {
        this.name = name;
        this.desc = desc;
        this.isTemplate = isTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }
}
