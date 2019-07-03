
package io.github.berson.itsdone.Models.Notes;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notes implements Serializable, Parcelable
{

    @SerializedName("Message")
    @Expose
    private Message message;
    @SerializedName("Notas")
    @Expose
    private List<Nota> notas = null;
    public final static Creator<Notes> CREATOR = new Creator<Notes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        public Notes[] newArray(int size) {
            return (new Notes[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2558535544784279685L;

    protected Notes(Parcel in) {
        this.message = ((Message) in.readValue((Message.class.getClassLoader())));
        in.readList(this.notas, (Nota.class.getClassLoader()));
    }

    public Notes() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeList(notas);
    }

    public int describeContents() {
        return  0;
    }

}
