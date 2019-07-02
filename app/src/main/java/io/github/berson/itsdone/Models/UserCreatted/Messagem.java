
package io.github.berson.itsdone.Models.UserCreatted;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Messagem implements Serializable, Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("messagem")
    @Expose
    private String messagem;
    public final static Parcelable.Creator<Messagem> CREATOR = new Creator<Messagem>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Messagem createFromParcel(Parcel in) {
            return new Messagem(in);
        }

        public Messagem[] newArray(int size) {
            return (new Messagem[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4117722568263788784L;

    protected Messagem(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.messagem = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Messagem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(messagem);
    }

    public int describeContents() {
        return  0;
    }

}
