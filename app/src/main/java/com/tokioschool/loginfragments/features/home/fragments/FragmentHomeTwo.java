package com.tokioschool.loginfragments.features.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tokioschool.loginfragments.R;
import com.tokioschool.loginfragments.databinding.FragmentHomeTwoBinding;
import com.tokioschool.loginfragments.domain.CarItem;
import com.tokioschool.loginfragments.domain.User;
import com.tokioschool.loginfragments.features.home.adapters.ListaCochesAdapter;
import com.tokioschool.loginfragments.features.home.fragments.vm.ListCarViewModel;

import java.util.List;

public class FragmentHomeTwo extends Fragment {

    private static final String TAG = "FragmentHomeTwo";
    private FragmentHomeTwoBinding binding;
    private ListCarViewModel viewmodel;

    public FragmentHomeTwo() {

    }

    public static FragmentHomeTwo newInstance(User user) {
        FragmentHomeTwo fragment = new FragmentHomeTwo();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentHomeTwoBinding binding = FragmentHomeTwoBinding.bind(view);
        viewmodel = new ViewModelProvider(this, new ListCarViewModel.Factory()).get(ListCarViewModel.class);
        viewmodel.loadCarList();
        viewmodel.getCarList().observe(getViewLifecycleOwner(), carItems -> {
            setupRecycler(binding, carItems);
        });

    }

    private void setupRecycler(FragmentHomeTwoBinding binding, List<CarItem> carItems) {
        binding.fragmentListacochesRecycler.setHasFixedSize(true);
        binding.fragmentListacochesRecycler.setAdapter(new ListaCochesAdapter(carItems, new ListaCochesAdapter.OnItemCarClick() {

            @Override
            public void onItemClickCar(CarItem carItem) {
                Toast.makeText(getActivity(), getString(R.string.car_type_message,carItem.getCarType()), Toast.LENGTH_SHORT).show();
            }
        }));
    }

}