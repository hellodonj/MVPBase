package com.example.mvpbase.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpbase.LoginContract;
import com.example.mvpbase.R;
import com.example.mvpbase.model.LoginPresenterImp;

/**
 * 描述:
 * 作者|时间: djj on 2019/5/24 0024 下午 4:05
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public class MainActivity extends BaseMvpActivity<LoginContract.ILoginPresenter>
        implements LoginContract.ILoginView {

    private EditText mUserName;
    private EditText mPassword;
    private Button mBtnLogin;

    @Override
    protected LoginContract.ILoginPresenter createPresenter() {
        return new LoginPresenterImp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = findViewById(R.id.et_name);
        mPassword = findViewById(R.id.et_password);
        mBtnLogin = findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = mUserName.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                mPresenter.login(userName, password);
            }
        });
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功！", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}
