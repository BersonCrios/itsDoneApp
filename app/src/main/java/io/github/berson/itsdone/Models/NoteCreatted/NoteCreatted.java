
package io.github.berson.itsdone.Models.NoteCreatted;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.berson.itsdone.Models.Notes.Message;

public class NoteCreatted implements Serializable, Parcelable
{

    @SerializedName("Message")
    @Expose
    private io.github.berson.itsdone.Models.Notes.Message message;
    @SerializedName("note")
    @Expose
    private Note note;
    public final static Creator<NoteCreatted> CREATOR = new Creator<NoteCreatted>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NoteCreatted createFromParcel(Parcel in) {
            return new NoteCreatted(in);
        }

        public NoteCreatted[] newArray(int size) {
            return (new NoteCreatted[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4139506803226036699L;

    protected NoteCreatted(Parcel in) {
        this.message = ((io.github.berson.itsdone.Models.Notes.Message) in.readValue((io.github.berson.itsdone.Models.Notes.Message.class.getClassLoader())));
        this.note = ((Note) in.readValue((Note.class.getClassLoader())));
    }

    public NoteCreatted() {
    }

    public io.github.berson.itsdone.Models.Notes.Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeValue(note);
    }

    public int describeContents() {
        return  0;
    }

}
