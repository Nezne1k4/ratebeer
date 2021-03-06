# RateBeer for Android

Find [RateBeer in the Play Store](https://play.google.com/store/apps/details?id=com.ratebeer.android)

![Screenshot](/assets/screenshot.png?raw=true)

## History and goals

Evolution and simplification to bring the old RateBeer for Android app up to modern Android code and design standards, while being more reliable and less prone to ratebeer.com server changes and instabilities.

Designed and developed by [Eric Kok](eric@2312.nl) of [2312 development](http://2312.nl). Contributions by various others (see commit log).

## Project setup

The project should compile without any additional work, as all dependencies are managed through Gradle. The Android Jack toolchain is used to support Java 8 style labdas. Android devices with 4.0.3 (API level 15) and up are supported, without any tablet-specific interface for the moment. The project uses RxJava heavily to manage data streams (loading, caching), async processing and event notifications. The source data is defined by the RateBeer JSON API only, for which [limited documentation exists](https://www.ratebeer.com/json/ratebeerapi.asp). Most data shown in the app is temporarily cached in the database, with a fixed time limit to refresh data. Offline ratings of the signed in user are stored in the database after a manually-started sync (managed by a background Service).

## License

Designed and developed by [Eric Kok](eric@2312.nl) of [2312 development](http://2312.nl), with contributions by various others (see commit log). Published under the GNU GPL v3 (copyleft) license.
    
    Copyright 2010-2016 Eric Kok et al.
    
    RateBeer for Android is free software: you can redistribute it 
    and/or modify it under the terms of the GNU General Public 
    License as published by the Free Software Foundation, either 
    version 3 of the License, or (at your option) any later version.

    RateBeer for Android is distributed in the hope that it will be 
    useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
    of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with RateBeer for Android.  If not, see 
    <http://www.gnu.org/licenses/>.
    
See LICENSE.txt for the full license. Remember that, practically speaking,  you can NOT use this code without publishing the derivative code under the GNU GPL v3 license as well. Thanks for sharing!

Some code/libraries/resources are used in the project:

*  [RxJava](https://github.com/ReactiveX/RxJava) by Netflix, Inc
*  [RxAndroid](https://github.com/ReactiveX/RxAndroid) by The RxAndroid authors
*  [RxBinding](https://github.com/JakeWharton/RxBinding) by Jake Wharton et al.
*  [RxLifecycle](https://github.com/trello/RxLifecycle) by Trello, Inc
*  [RxTuples](https://github.com/pakoito/RxTuples) by pakoito
*  [Retrofit](http://square.github.io/retrofit/) by Square, Inc
*  [Gson](https://github.com/google/gson) by Google, Inc
*  [Cupboard](https://bitbucket.org/littlerobots/cupboard) by Hugo Visser et al.
*  [RxCupboard](https://github.com/erickok/RxCupboard) by Eric Kok et al.
*  [Picasso](http://square.github.io/picasso/) by Square, Inc
*  [HTMLEntities](http://sourceforge.net/projects/htmlentities/) by Nicola Asuni, copied into project under GNU LGPL v2.1
