package com.jvinteractivecr.miconta.ui.exchangerate;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jvinteractivecr.miconta.R;
import com.jvinteractivecr.miconta.constants.Errors;
import com.jvinteractivecr.miconta.constants.Messages;
import com.jvinteractivecr.miconta.databinding.FragmentExchangeRateBinding;
import com.jvinteractivecr.miconta.dbhelpers.ExchangeRateDbHelper;
import com.jvinteractivecr.miconta.models.ExchangeRateModel;

import org.intellij.lang.annotations.Language;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ExchangeRateFragment extends Fragment {

    private FragmentExchangeRateBinding binding;
    private EditText txt_exchange_rate_date, txt_exchange_rate_buy, txt_exchange_rate_sell;
    private ImageButton btn_exchange_rate_save;
    private TextView txt_last_update;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ExchangeRateViewModel exchangeRateViewModel =
                new ViewModelProvider(this).get(ExchangeRateViewModel.class);

        binding = FragmentExchangeRateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        txt_exchange_rate_date = binding.txtExchangeRateDate;
        txt_exchange_rate_buy = binding.txtExchangeRateBuy;
        txt_exchange_rate_sell = binding.txtExchangeRateSell;
        btn_exchange_rate_save = binding.btnExchangeRateSave;
        txt_last_update = binding.txtLastModified;

        getData();

        exchangeRateViewModel.getTxtExchangeRateDate().observe(getViewLifecycleOwner(), txt_exchange_rate_date::setText);
        exchangeRateViewModel.getTxtExchangeRateBuy().observe(getViewLifecycleOwner(), txt_exchange_rate_buy::setText);
        exchangeRateViewModel.getTxtExchangeRateSell().observe(getViewLifecycleOwner(), txt_exchange_rate_sell::setText);
        exchangeRateViewModel.getTxtLastUpdate().observe(getViewLifecycleOwner(), txt_last_update::setText);

        btn_exchange_rate_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    updateExchangeRate();
                    Toast.makeText(getContext(), Messages.UPDATE_SUCCESS, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void updateExchangeRate() throws Exception {
        if (txt_exchange_rate_date.getText() == null) {
            throw new Exception(Errors.MISSING_EXCHANGE_RATE_DATE);
        }

        if (txt_exchange_rate_buy.getText() == null) {
            throw new Exception(Errors.MISSING_EXCHANGE_RATE_BUY);
        }

        if (txt_exchange_rate_sell.getText() == null) {
            throw new Exception(Errors.MISSING_EXCHANGE_RATE_SELL);
        }

        ExchangeRateModel exchangeRateModel = new ExchangeRateModel();
        exchangeRateModel.setExchangeRateDate(String.valueOf(txt_exchange_rate_date.getText()));
        exchangeRateModel.setBuy(Double.valueOf(String.valueOf(txt_exchange_rate_buy.getText())));
        exchangeRateModel.setSell(Double.valueOf(String.valueOf(txt_exchange_rate_sell.getText())));

        ExchangeRateDbHelper dbHelper = new ExchangeRateDbHelper(getContext());
        dbHelper.updateExchangeRate(exchangeRateModel);

        txt_last_update.setText(Messages.LAST_UPDATE + txt_exchange_rate_date.getText());
    }

    private void getData() {
        ExchangeRateDbHelper dbHelper = new ExchangeRateDbHelper(getContext());
        ExchangeRateModel exchangeRateModel = dbHelper.getExchangeRate();
        txt_exchange_rate_buy.setText(exchangeRateModel.getBuy().toString());
        txt_exchange_rate_sell.setText(exchangeRateModel.getSell().toString());
        txt_last_update.setText(Messages.LAST_UPDATE + exchangeRateModel.getExchangeRateDate());

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);

                String myFormat = "MM/dd/yy";
                SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
                txt_exchange_rate_date.setText(dateFormat.format(myCalendar.getTime()));
            }
        };
        txt_exchange_rate_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}