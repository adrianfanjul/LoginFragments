package com.tokioschool.loginfragments.login.fragments;

import static com.tokioschool.loginfragments.constants.Constants.USER;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.tokioschool.loginfragments.home.HomeActivity;
import com.tokioschool.loginfragments.R;
import com.tokioschool.loginfragments.databinding.FragmentLoginBinding;
import com.tokioschool.loginfragments.domain.User;
import com.tokioschool.loginfragments.login.viewmodel.SharedViewModel;

public class FragmentLogin extends Fragment {
    private User user;
    private FragmentLoginBinding binding;
    private SharedViewModel viewModel;
    private static final String TAG="FragmentLogin";

    public static FragmentLogin newInstance() {
        FragmentLogin fragment=new FragmentLogin();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getUser().observe(getViewLifecycleOwner(),user->{
            this.user=user;
        });
        listeners();
        viewModel.setFragment(TAG);
    }

    private void listeners() {
        binding.loginForgotLink.setOnClickListener(view -> Snackbar.make(binding.getRoot(), R.string.login_snackbar_text, BaseTransientBottomBar.LENGTH_SHORT).show());
        binding.loginAccountLink.setOnClickListener(view -> {
            FragmentRegister fragment = new FragmentRegister();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_fragments_Login,fragment);
            ft.addToBackStack(null);
            ft.commit();
        });
        binding.loginInputLoginText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableButton();
            }
        });
        binding.loginInputPasswordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableButton();
            }
        });
        binding.loginButtonLogin.setOnClickListener(view -> userLogin(user));
    }

    private void userLogin(User user) {
        if(user==null){
            Toast.makeText(requireActivity(), R.string.login_no_register, Toast.LENGTH_SHORT).show();
        }else{
            if(binding.loginInputLoginText.getText().toString().equals(user.getUsername()) && binding.loginInputPasswordText.getText().toString().equals(user.getPassword())){
                Intent intent=new Intent(getContext(), HomeActivity.class);
                intent.putExtra(USER, user);
                startActivity(intent);
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
                builder.setTitle(R.string.login_validation_fail);
                builder.setPositiveButton(R.string.login_button_ok, (dialog, id) -> {
                    dialog.dismiss();
                }).create().show();
            }
        }
    }

    private void enableButton() {
        if(binding.loginInputLoginText.getText().length()>0 && binding.loginInputPasswordText.getText().length()>0)
            binding.loginButtonLogin.setEnabled(true);
        else
            binding.loginButtonLogin.setEnabled(false);
    }

}