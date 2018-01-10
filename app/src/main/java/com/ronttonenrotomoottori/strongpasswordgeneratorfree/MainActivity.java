package com.ronttonenrotomoottori.strongpasswordgeneratorfree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.ClipboardManager;
import android.content.Context;
import org.w3c.dom.Text;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    boolean upperChecked = true;
    boolean lowerChecked = true;
    boolean numberChecked = true;
    boolean specialChecked = true;
    char [] specials = "!@#£$%{[]}/()=}?+&".toCharArray();
    char [] upperLetters = "ABCDEFGHIJKLMOPQRSTUVWXYZ".toCharArray();
    char [] lowerLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char [] numbers = "1234567890".toCharArray();

    //0 = upper, 1 = lower, 2 = numbers, 3 = specials

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MobileAds.initialize(this, "ca-app-pub-3555097125550655~2011993471");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }






    public void checkBoxFunction(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.upperCaseCheckBox:
                if(checked) {
                    upperChecked = true;
                } else {
                    upperChecked = false;
                }
                break;

            case R.id.lowerCaseCheckBox:
                if(checked) {
                    lowerChecked = true;
                } else {
                    lowerChecked = false;
                }
                break;

            case R.id.numbersCheckBox:
                if(checked) {
                    numberChecked = true;
                } else {
                    numberChecked = false;
                }
                break;

            case R.id.specialCharactersCheckBox:
                if (checked) {
                    specialChecked = true;
                }
                else {
                    specialChecked = false;
                }
                break;
        }

    }

    public void changeLength(View view) {

        TextView atmValue = (TextView)findViewById(R.id.lengthField);
        String atmValueAsString = atmValue.getText().toString();
        int atmValueAsInt = Integer.parseInt(atmValueAsString);


        switch (view.getId()) {
            case R.id.moreLength:
                atmValueAsInt += 1;
                break;

            case R.id.lessLength:
                if (atmValueAsInt > 1) {
                    atmValueAsInt -= 1;
                }
                break;
        }

        atmValueAsString = Integer.toString(atmValueAsInt);
        atmValue.setText(atmValueAsString);

    }

    public String randomString(int whichString, int length) {
        int chooseFromCharArray;
        int chooseCharArray;
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();

        switch (whichString) {
            //only upper
            case 0:
                while (result.length() < length) {
                    int index = (int) (rnd.nextFloat() * upperLetters.length);
                    result.append(upperLetters[index]);
                }
                break;
            //only lower
            case 1:
                while (result.length() < length) {
                    int index = (int) (rnd.nextFloat() * lowerLetters.length);
                    result.append(lowerLetters[index]);
                }
                break;
            //only numbers
            case 2:
                while (result.length() < length) {
                    int index = (int) (rnd.nextFloat() * numbers.length);
                    result.append(numbers[index]);
                }
                break;
            //only specials
            case 3:
                while (result.length() < length) {
                    int index = (int) (rnd.nextFloat() * specials.length);
                    result.append(specials[index]);
                }
                break;
            //upper + lower
            case 4:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 2 + 1);
                    if (array == 1) {
                        int index = (int) (rnd.nextFloat() * upperLetters.length);
                        result.append(upperLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * lowerLetters.length);
                        result.append(lowerLetters[index]);
                    }
                }
                break;
            //upper + number
            case 5:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 2 + 1);
                    if (array == 1) {
                        int index = (int) (rnd.nextFloat() * upperLetters.length);
                        result.append(upperLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * numbers.length);
                        result.append(numbers[index]);
                    }
                }
                break;
            //upper + special
            case 6:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 2 + 1);
                    if (array == 1) {
                        int index = (int) (rnd.nextFloat() * upperLetters.length);
                        result.append(upperLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * specials.length);
                        result.append(specials[index]);
                    }
                }
                break;
            //lower + number
            case 7:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 2 + 1);
                    if (array == 1) {
                        int index = (int) (rnd.nextFloat() * lowerLetters.length);
                        result.append(lowerLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * numbers.length);
                        result.append(numbers[index]);
                    }
                }
                break;
            //lower + special
            case 8:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 2 + 1);
                    if (array == 1) {
                        int index = (int) (rnd.nextFloat() * specials.length);
                        result.append(specials[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * lowerLetters.length);
                        result.append(lowerLetters[index]);
                    }
                }
                break;
            //numbers + specials
            case 9:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 2 + 1);
                    if (array == 1) {
                        int index = (int) (rnd.nextFloat() * numbers.length);
                        result.append(numbers[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * specials.length);
                        result.append(specials[index]);
                    }
                }
                break;
            //upper + lower + number
            case 10:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 4);
                    if (array == 0) {
                        int index = (int) (rnd.nextFloat() * upperLetters.length);
                        result.append(upperLetters[index]);
                    } else if (array == 1) {
                        int index = (int) (rnd.nextFloat() * lowerLetters.length);
                        result.append(lowerLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * numbers.length);
                        result.append(numbers[index]);
                    }
                }
                break;
            //upper + lower+ special
            case 11:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 4);
                    if (array == 0) {
                        int index = (int) (rnd.nextFloat() * upperLetters.length);
                        result.append(upperLetters[index]);
                    } else if (array == 1) {
                        int index = (int) (rnd.nextFloat() * lowerLetters.length);
                        result.append(lowerLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * specials.length);
                        result.append(specials[index]);
                    }
                }
                break;
            //upper + number + special
            case 12:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 4);
                    if (array == 0) {
                        int index = (int) (rnd.nextFloat() * upperLetters.length);
                        result.append(upperLetters[index]);
                    } else if (array == 1) {
                        int index = (int) (rnd.nextFloat() * numbers.length);
                        result.append(numbers[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * specials.length);
                        result.append(specials[index]);
                    }
                }
                break;
            //lower + special + number
            case 13:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 4);
                    if (array == 0) {
                        int index = (int) (rnd.nextFloat() * specials.length);
                        result.append(specials[index]);
                    } else if (array == 1) {
                        int index = (int) (rnd.nextFloat() * lowerLetters.length);
                        result.append(lowerLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * numbers.length);
                        result.append(numbers[index]);
                    }
                }
                break;
            //all checked
            case 14:
                while (result.length() < length) {
                    int array = (int) (rnd.nextFloat() * 5);
                    if (array == 0) {
                        int index = (int) (rnd.nextFloat() * upperLetters.length);
                        result.append(upperLetters[index]);
                    } else if (array == 1) {
                        int index = (int) (rnd.nextFloat() * lowerLetters.length);
                        result.append(lowerLetters[index]);
                    } else if (array == 2) {
                        int index = (int) (rnd.nextFloat() * numbers.length);
                        result.append(numbers[index]);
                    } else if (array == 3) {
                        int index = (int) (rnd.nextFloat() * specials.length);
                        result.append(specials[index]);
                    }
                }

                break;

        }
        return result.toString();
    }

    public void generatePassword(View view) {
        TextView lengthView = (TextView)findViewById(R.id.lengthField);
        String lengthString = lengthView.getText().toString();
        int length = Integer.parseInt(lengthString);
        TextView hereGoesPassword = (TextView)findViewById(R.id.passwordField);
        if (length < 1) {
            hereGoesPassword.setText("Please enter valid length");
            return;
        }

        if(upperChecked && !lowerChecked && !numberChecked && !specialChecked) {
            hereGoesPassword.setText(randomString(0, length));
        } else if (lowerChecked && !upperChecked && !numberChecked && !specialChecked) {
            hereGoesPassword.setText(randomString(1,length));
        } else if (numberChecked && !upperChecked && !lowerChecked && !specialChecked) {
            hereGoesPassword.setText(randomString(2,length));
        } else if (specialChecked && !numberChecked && !upperChecked && !lowerChecked) {
            hereGoesPassword.setText(randomString(3,length));
        }


        else if (upperChecked && lowerChecked && !numberChecked && !specialChecked) {
            hereGoesPassword.setText(randomString(4,length));
        } else if (numberChecked && !specialChecked && upperChecked && !lowerChecked) {
            hereGoesPassword.setText(randomString(5,length));
        } else if (upperChecked && specialChecked && !numberChecked && !lowerChecked) {
            hereGoesPassword.setText(randomString(6,length));
        }  else if (lowerChecked && numberChecked && !upperChecked && !specialChecked) {
            hereGoesPassword.setText(randomString(7,length));
        } else if(lowerChecked&& specialChecked && !numberChecked && !upperChecked) {
            hereGoesPassword.setText(randomString(8,length));
        } else if (numberChecked && specialChecked && !upperChecked && !lowerChecked) {
            hereGoesPassword.setText(randomString(9,length));
        }


        else if (upperChecked && lowerChecked && numberChecked && !specialChecked) {
            hereGoesPassword.setText(randomString(10, length));
        } else if (upperChecked && lowerChecked && !numberChecked && specialChecked) {
            hereGoesPassword.setText(randomString(11, length));
        } else if (!lowerChecked && numberChecked && specialChecked && upperChecked) {
            hereGoesPassword.setText(randomString(12, length));
        } else if (lowerChecked && specialChecked && !upperChecked && numberChecked) {
            hereGoesPassword.setText(randomString(13,length));
        }


        else if (upperChecked && numberChecked && lowerChecked && upperChecked) {
            hereGoesPassword.setText(randomString(14,length));
        } else if(!upperChecked && !numberChecked&& !lowerChecked && !specialChecked) {
            hereGoesPassword.setText("Please check at least one option.");
        }


    }

    public void copyPasswordToClipBoard(View view) {
        TextView tv = (TextView)findViewById(R.id.passwordField);
        String stringYouExtracted = tv.getText().toString();
        // int startIndex = tv.getSelectionStart();
        // int endIndex = tv.getSelectionEnd();
        // stringYouExtracted = stringYouExtracted.subString(startIndex, endIndex);
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(stringYouExtracted);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Password", stringYouExtracted);
            clipboard.setPrimaryClip(clip);
        }
        Context context = getApplicationContext();
        CharSequence text = "Password copied to clipboard";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
