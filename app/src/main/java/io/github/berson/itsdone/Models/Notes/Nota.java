
package io.github.berson.itsdone.Models.Notes;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nota implements Serializable, Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("__v")
    @Expose
    private Integer v;
    public final static Creator<Nota> CREATOR = new Creator<Nota>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Nota createFromParcel(Parcel in) {
            return new Nota(in);
        }

        public Nota[] newArray(int size) {
            return (new Nota[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2336853127407057055L;

    protected Nota(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Nota() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(text);
        dest.writeValue(isActive);
        dest.writeValue(v);
    }

    public int describeContents() {
        return  0;
    }

}
