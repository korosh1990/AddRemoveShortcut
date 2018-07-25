package ir.androidlife.addremoveshortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button) findViewById(R.id.addShortcut);
        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                addShortcutIcon();
                //Toast.makeText(MainActivity.this,"میانبر اضافه شد",Toast.LENGTH_LONG).show();
            }
        });

        Button remove = (Button) findViewById(R.id.removeShortcut);
        remove.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                removeShortcutIcon();
                //Toast.makeText(MainActivity.this,"میانبر حذف شد",Toast.LENGTH_LONG).show();
            }
        });
    }

        private void addShortcutIcon() {

        //Code Snippet to Add shortcut Icon.
        Intent shortcutAdd = new Intent(getApplicationContext(), MainActivity.class);
        //Instead of MainActivity you can add any activity from you application.
        shortcutAdd.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutAdd);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "اندروید لایف");
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.shortcut));
        //Above Line is for your application Shortcut Icon.
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        getApplicationContext().sendBroadcast(addIntent);
    }

        private void removeShortcutIcon() {
        //Code Snippet to Remove shortcut Icon.
        Intent shortcutRem = new Intent(getApplicationContext(), MainActivity.class);
        shortcutRem.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutRem);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "اندروید لایف");

        addIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        getApplicationContext().sendBroadcast(addIntent);
    }
}
