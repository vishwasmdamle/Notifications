package anon.ext.notifications.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import anon.ext.notifications.R;
import anon.ext.notifications.actors.NotificationActor;
import anon.ext.notifications.handlers.NotificationLogicHandler;


public class NotificationActivity extends AppCompatActivity implements NotificationActor {

  private NotificationLogicHandler handler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notification);
    handler = new NotificationLogicHandler(this, this);
    handler.onCreate();
  }

  @Override
  public void startInfoActivity() {

  }
}
