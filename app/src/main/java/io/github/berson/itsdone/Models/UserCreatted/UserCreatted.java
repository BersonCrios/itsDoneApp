
package io.github.berson.itsdone.Models.UserCreatted;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserCreatted implements Serializable, Parcelable
{

    @SerializedName("messagem")
    @Expose
    private Messagem messagem;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("token")
    @Expose
    private String token;
    public final static Parcelable.Creator<UserCreatted> CREATOR = new Creator<UserCreatted>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserCreatted createFromParcel(Parcel in) {
            return new UserCreatted(in);
        }

        public UserCreatted[] newArray(int size) {
            return (new UserCreatted[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4502408148251985757L;

    protected UserCreatted(Parcel in) {
        this.messagem = ((Messagem) in.readValue((Messagem.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserCreatted() {
    }

    public Messagem getMessagem() {
        return messagem;
    }

    public void setMessagem(Messagem messagem) {
        this.messagem = messagem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(messagem);
        dest.writeValue(user);
        dest.writeValue(token);
    }

    public int describeContents() {
        return  0;
    }

}
