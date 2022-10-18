from django.contrib import admin
from django.urls import path

from .views import *

urlpatterns = [
    path('example/<slug:name>/', example_view),
    path('shorten/', shorten_url),
    path('redirect/<slug:custom_name>/', redirect_url),
    path('', shorten_url),
]
