package io.github.berson.itsdone.Models.NoteCreate;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotesCreate implements Serializable, Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    public final static Parcelable.Creator<NotesCreate> CREATOR = new Creator<NotesCreate>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NotesCreate createFromParcel(Parcel in) {
            return new NotesCreate(in);
        }

        public NotesCreate[] newArray(int size) {
            return (new NotesCreate[size]);
        }

    }
            ;
    private final static long serialVersionUID = 8478883797038555692L;

    protected NotesCreate(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.isActive = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public NotesCreate() {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(text);
        dest.writeValue(isActive);
    }

    public int describeContents() {
        return 0;
    }

}