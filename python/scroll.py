import pyautogui
import time

# You can adjust the number of scrolls and the duration
scroll_distance = 100000  # Positive number scrolls down, negative scrolls up
num_scrolls = 50  # Number of scrolls to perform

# Give a moment before the scrolling starts to focus on the browser window
time.sleep(2)

for _ in range(num_scrolls):
    pyautogui.scroll(scroll_distance)
    time.sleep(0.1)  # Adjust the delay between scrolls if needed
