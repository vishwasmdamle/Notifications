package anon.ext.notifications.handlers;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import anon.ext.notifications.actors.NotificationActor;
import anon.ext.notifications.services.ReceiverService;
import anon.ext.notifications.services.SharedPreferenceUtil;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotificationLogicHandlerTest {

  private NotificationLogicHandler handler;
  @Mock
  private NotificationActor actor;
  @Mock
  private SharedPreferenceUtil sharedPrefUtil;

  @Before
  public void setUp() throws Exception {
    handler = new NotificationLogicHandler(sharedPrefUtil, actor);
  }

  @Test
  public void shouldDisplayInfoActivityIfNotificationAccessIsNotEnabled() throws Exception {
    when(sharedPrefUtil.getBoolean(ReceiverService.RECEIVER_STATUS, false)).thenReturn(false);

    handler.onCreate();

    verify(actor).startInfoActivity();
  }
}