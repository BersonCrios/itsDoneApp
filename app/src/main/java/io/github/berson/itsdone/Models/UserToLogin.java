package io.github.berson.itsdone.Models;

        import java.io.Serializable;
        import android.os.Parcel;
        import android.os.Parcelable;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class UserToLogin implements Serializable, Parcelable {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    public final static Parcelable.Creator<UserToLogin> CREATOR = new Creator<UserToLogin>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserToLogin createFromParcel(Parcel in) {
            return new UserToLogin(in);
        }

        public UserToLogin[] newArray(int size) {
            return (new UserToLogin[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4037317072250838574L;

    protected UserToLogin(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserToLogin() {
    }

    public UserToLogin(String usuario, String senha) {
        this.username = usuario;
        this.password = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(password);
    }

    public int describeContents() {
        return 0;
    }

}