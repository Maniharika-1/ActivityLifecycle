# ActivityLifecycle
1. When a dialog is opened from an activity, what are the lifecycle states that the activity will go through?
* If dialog is created using AlertDialogBuilder or Dialog class, there will be no change in the activity lifecycle. onPause() will not be called in this case. These dialogs are always tied up to the calling activity. Dialog cannot be visible if the activity is not running. 
onPause() is called when the activity is no longer at the top of the activity stack. A Dialog by itself is not an activity, so will not replace the current activity at the top of the stack and hence will not cause anything to pause.
* onPause() will only be called when you are calling another activity as dialog (using dialog theme, or an activity which does not cover full screen). In this case, displaying the dialog-as-an-Activity will cause the new Activity to be on the top of the stack, pausing what previously was there. Calling activity will go into pause state when dialog as activity is called and dialog as activity will go through - onCreate(), onStart(), onResume(), onPostResume().

2. When you call dialog as an activity from onCreate() of current activity, what will be the lifecycle states of current activity?
* Current activity will not directly go to pause state. onStart() and onResume() of the current activity will be called and then onPause() will be called.

3. When you drag notification bar and your activity is not visible at all, what will be the lifecycle state of Activity?
* No change in activity lifecycle state. onPause() will not be called as current activity will still be on top of the stack even though notification bar is dragged.

4. What will be the sequence of lifecycle states when you go from Activity A to Activity B?
* 
  * Activity A - onPause()
  * Activity B - onCreate()
  * Activity B - onStart()
  * Activity B - onPause()
  * Activity A - onStop()

5. What will be the sequence of lifecycle states when you go from Activity B to Activity A with back button?
* 
  * Activity B - onPause()
  * Activity A - onRestart()
  * Activity A - onStart()
  * Activity A - onResume()
  * Activity B - onStop()
  * Activity B - onDestroy()

6. What will be the sequence of lifecycle states when you navigate to recents or launcher when your activity is open?
* onPause() then onStop()

7. What will be the sequence of lifecycle states of Activity and Fragment when a dialog as an activity is called in the onCreate() of a fragment?
* 
  * Fragment - onAttach()
  * Fragment - onCreate()
  * Activity - onCreate()
  * Fragment - onCreateView()
  * Fragment - onViewCreated()
  * Fragment - onActivityCreated()
  * Fragment - onStart()
  * Activity - onStart()
  * Activity - onResume()
  * Fragment - onResume()
  * Fragment - onPause()
  * Activity - onPause()

