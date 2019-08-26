package com.development.seowoo.foodorder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


public class SignInFragment extends Fragment{

    public SignInFragment() {

    }

    private TextView dontHaveAnAccount;
    private FrameLayout parentFrameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAnAccount = view.findViewById(R.id.tv_dont_have_an_account);
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        return view;
    }

    /**
     * onViewCreated(View view, Bundle savedInstanceState)
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned,
     * but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once they know their view hierarchy has been completely created.
     * The fragment's view hierarchy is not however attached to its parent at this point.
     * [출처] onViewCreated 와 onCreateView의 차이점|작성자 블랙독
     *
     *
     onViewCreated (뷰보기, Bundle savedInstanceState)
     onCreateView (LayoutInflater, ViewGroup, Bundle)가
     리턴 된 직후에 저장된 상태가보기로 복원되기 전에 호출됩니다.
     이를 통해 서브 클래스는 뷰 계층 구조가 완전히 생성 된 것을 알면 스스로 초기화 할 수 있습니다.
     그러나이 시점에서 프래그먼트의 뷰 계층 구조는 부모에 연결되지 않습니다.
     */

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dontHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}
