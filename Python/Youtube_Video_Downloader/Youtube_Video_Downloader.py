from pytube import YouTube
from tkinter import *

# Creating a window
window = Tk()
window.title("Youtube Video Downloader")
window.config(bg="PaleTurquoise1")
Label(window, text="Welcome to Youtube Video Downloader!!!", fg="Deepskyblue4", bg="bisque2", font=("Helvetica", 20, "bold")).grid(sticky=N,padx=120,row=0)
Label(window, text="Enter the URL of the video", fg="Deepskyblue4",bg="AntiqueWhite1", font=("Helvetica", 18)).grid(sticky=N,row=1, pady=20)
Label(window, text="Enter the path where to save the video", fg="Deepskyblue4", bg="AntiqueWhite1",font=("Helvetica", 18)).grid(sticky=N,row=4, pady=20)

# Create the application variable.
url = StringVar()
path = StringVar()

# Entry
Entry(window, width=100, textvariable=url).grid(sticky=N, row=2)
Entry(window, width=100, textvariable=path).grid(sticky=N, row=5)

def download_youtube_video():
    link = url.get()
    path_to_save_video = path.get()
    try:
        youtube = YouTube(link)
        # Display video details
        title = "Title", youtube.title
        views = "Number of views: ", youtube.views
        len = "Length of video: ", youtube.length
        rate = "Rating of video: ", youtube.rating

        Label(window, text=title, fg="salmon", bg="ivory2", font=("Helvetica", 12)).grid(sticky=N, row=7,pady=20)
        Label(window, text=views, fg="salmon", bg="ivory2", font=("Helvetica", 12)).grid(sticky=N, row=8, pady=20)
        Label(window, text=len, fg="salmon", bg="ivory2", font=("Helvetica", 12)).grid(sticky=N, row=9, pady=20)
        Label(window, text=rate, fg="salmon", bg="ivory2", font=("Helvetica", 12)).grid(sticky=N, row=10, pady=20)

        # Get the highest resolution
        download_youtube = youtube.streams.get_highest_resolution()

        # Downloading a video
        Label(window, text="Downloading...", fg="red",bg="ivory2", font=("Helvetica", 12)).grid(sticky=N, row=11, pady=20)
        download_youtube.download(path_to_save_video)
        Label(window,text="Successfully downloaded the video", fg="green", bg="ivory2", font=("Helvetica", 14)).grid(sticky=N, pady=1, row=12)

    except Exception as e:
        print(e)
        Label(window, text="Video could not be downloaded", fg="red",bg="ivory2", font=("Helvetica", 14)).grid(sticky=N, pady=1,row=12)

# Botton
Button(window, width=20, text="Download", font=("Helvetica",12, "bold"),bg="mint cream", command=download_youtube_video).grid(sticky=N,row=6,pady=15)
window.mainloop()


