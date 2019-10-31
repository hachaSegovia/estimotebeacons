# Change Log

## Version 0.9.3.os (October 19, 2017)

* Removed unsupported APIs (ranging, scanning and nearables support.)
* Added history functionality. Regions registered with log history will be saved on the database and can later be fetched using `getAllEvents` and `getLastEvent`. History events do not generate a system notification but are delivered into the application if the app is running in foreground.

Android updates:

* Added location permission request for Android 23+ through `requestAlwaysAuthorization()`
* Code clean up and removal of unused code

iOS updates:

* Added missing description for location usage
* Fixed bug that caused the application to enter an infinite recursive loop when tapping a region notification
* Code clean up and removal of unused code

## Version 0.9.0 (March 23, 2016)

Changes by OutSystems

iOS updates:

* Added a category to AppDelegate in order to receive enter/exit events from monitored regions.
* Local notifications are mapped into default NSNoticationCenter and EstimotePlugin listens to default NSNotificationCenter
* Registered monitored Regions are saved into a plist
* Added the concept of NotificationRegion
* Added authorization request to use notifications in the application.

Android updates:

* Update of Estimote Android SDK
* Added the concept of NotificationRegion
* Added a background service (BeaconsMonitoringService) to integrate with Estimote SDK, allowing for background monitoring of registered regions
  * BeaconsMonitoringService is responsible for creating local notifications on entering/exiting a monitoring region OR for sending notification to WebView.
  * BeaconsMonitoringService is enabled or disabled depending on the status of bluetooth adapter.
* Registered regions are saved on SQL-lite database.

Other updates:

* Updated documentation

## Version 0.8.0 (Jul 25, 2015)

iOS updates:

* Update of Estimote iOS SDK to version 3.3.1
* Change of JS API based on changes in iOS SDK 3.3.1 (secure beacons and Bluetooth based scanning, see below)
* Changed JS API for secure beacons, new functions estimote.beacons.startRangingSecureBeaconsInRegion, estimote.beacons.stopRangingSecureBeaconsInRegion, estimote.beacons.startSecureMonitoringForRegion, estimote.beacons.stopSecureMonitoringForRegion
* Function estimote.beacons.startEstimoteBeaconsDiscoveryForRegion renamed to estimote.beacons.startEstimoteBeaconDiscovery (removed parameter region)

Android updates:

* Update of Estimote Android SDK to version 0.6.1 (thanks https://github.com/anulman)
* Support for connection on Android (thanks https://github.com/anulman)
* Support for Bluetooth dialog on Android (thanks https://github.com/ttcremers)

Other updates:

* Updated example app
* Updated documentation

## Version 0.7.1 (Feb 17, 2015)

* Improved trigger support
* Updated documentation

## Version 0.7.0 (Feb 11, 2015)

* Update to Estimote iOS SDK 2.4.0
* Update to Estimote Android SDK 0.4.3
* Nearable monitoring
* Support for triggers
* Support for Secure Beacons
* Support for ESTConfig methods
* Virtual beacons (using an iPhone as an Estimote Beacon)
* Updated example application (modular JS file structure, triggers example and more)
* Example application supports live coding with Evothings Workbench
* Updated documentation

## Version 0.6.0 (Jan 24, 2015)

* Update to Estimote iOS SDK 2.3.2
* Added Nearable Ranging API that supports Estimote Stickers
* Updated JS API to use modules "estimote.beacons" and "estimote.nearables" ("EstimoteBeacons" kept for backwards compatibility, points to "estimote.beacons")
* Update of example app to use new JS module names, added ranging for Estimote Stickers, improved touch support in file  touch.js
* Updated documentation
* Added this file (changelog.md)

## Version 0.5.1 (Dec 10, 2014)

* Distance and proximity properties added to Android plugin

## Version 0.5.0 (Nov 26, 2014)

* Updated example app
* Updated documentation

## Version 0.3.0 (Nov 20, 2014)

* Added Android plugin

## Version 0.2.0 (Oct 5, 2014)

* Update of original plugin
* Upgrade to Estimote iOS SDK 2.1
* Redesigned API (breaks backwards compatibility)
* Revamped example app
* Updated documentation

## Version 0.1.0 (Oct 11, 2013)

* Original plugin goes up on GitHub
* Development continues during 2014
