from django.shortcuts import render, redirect
from django.http import HttpResponse

from .models import *

# Create your views here.

def example_view(request, name):

    data = {
        "first_name": name
    }
    return render(request, 'index.html', data)

def shorten_url(request):
    context = {
        "submitted": False
    }
    
    if request.method == "POST":
        user_data = request.POST
        long_url = user_data['longurl']
        custom_name = user_data['custom_name']

        # push to the database
        try:
            obj = URL_table(
                long_url = long_url,
                custom_name = custom_name
            )
            obj.save()

            data = {
                "long_url": obj.long_url,
                "short_url": obj.custom_name,
                "date": obj.created_date,
                "clicks": obj.visit_count
            }

            context['submitted'] = True
            context['data'] = data;
        except:
            return HttpResponse("The custom name is already taken")
        print(long_url, custom_name)
        return HttpResponse("URL shortened successfully")
    
    return render(request, 'home.html', context)

def redirect_url(request, custom_name):
    try:
        row = URL_table.objects.get(custom_name=custom_name)
        long_url = row.long_url
        row.visit_count += 1
        row.save()
        return redirect(long_url)
    except:
        return HttpResponse("The custom name is not found")
    
    return HttpResponse(custom_name)