[TOC]

Android Basics with Compose
<https://developer.android.com/courses/android-basics-compose/course>

# Unit 1: Your first Android app

<https://developer.android.com/courses/android-basics-compose/unit-1>

- Build an Android app with a simple user interface that displays text and images.
- Run the app on a device or emulator.

## [unit1-birthday](unit1-birthday) Build a basic layout

<https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-3>

- Column
- Text
- Image

## [unit1-composearticle](unit2-composearticle)

<https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-3>

## [unit1-taskcompleted](unit2-taskcompleted)

<https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-3>

## [unit1-composequadrant](unit2-composequadrant)

<https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-3>

# Unit 2: Building app UI

<https://developer.android.com/courses/android-basics-compose/unit-2>

- Use conditionals, function types, classes, and lambda expressions in Kotlin.
- Understand how composition and recomposition works.
- Add a button to an app UI and respond to user taps.
- Create an app that works with data entered by the user.
- Learn how to use state to display data and reflect the changes automatically when the data gets updated.
- Write unit tests to test isolated functions.

## [unit2-diceroller](unit2-diceroller)  button

- remember
- mutableStateOf
- Spacer

## [unit2-tipcalculator](unit2-tipcalculator)  keyboard

<https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-3>

- hoist a state
- add an action button to a virtual keyboard.
- Switch composable
- Add leading icons

# Unit 3: Display lists and use Material Design

<https://developer.android.com/courses/android-basics-compose/unit-3>

Build apps that display a list of data and learn how to make your apps more beautiful with Material Design.
- Use data classes, functions, and collections in Kotlin.
- Create a scrollable list in an app that displays both text and images.
- Add click listeners to interact with list items.
- Add an app bar to the app and modify the app theme.
- Use Material Design to build modern and intuitive user interfaces, using colors, shapes and typography.


## [unit3-affirmations](unit3-affirmations) scrollable list and app icon

<https://developer.android.com/codelabs/basic-android-kotlin-compose-training-add-scrollable-list>

- Card
- LazyColumn

## [unit3-courses](unit3-courses) LazyVerticalGrid

- grid

## [unit3-woof](unit3-woof) material design and simple animation

<https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming>


![](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-material-theming/img/e0349c33dd6fbafe_856.png)

自定义Material Theme
<https://m3.material.io/theme-builder#/custom>

Compose为 Float 、 Color 、 Dp 、 Size 、 Offset 和 Int 提供了 animate*AsState() 函数
```kotlin
val color by animateColorAsState(
    targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
    else MaterialTheme.colorScheme.primaryContainer,
)
Column(
    modifier = Modifier.animateContentSize(
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium
        )
    ).background(color = color)
)
```

# Unit 4: Navigation and app architecture

<https://developer.android.com/courses/android-basics-compose/unit-4>

Learn the best practices of app architecture to build more complex apps. Enhance your users' ability to navigate across, into and back out from the various screens within your app for a consistent and predictable user experience.
- Explain activities and their lifecycles.
- Understand Modern Android architecture.
- Use StateFlow and UDF pattern to work with state and events.
- Add a ViewModel to save data and state.
- Set up and use the Navigation component with Compose.
- Understand what responsive UI is.
- Use window class sizes to build for different screen sizes.
- Add a navigation drawer to an app.

## [unit4-dessert-clicker](unit4-dessert-clicker) lifecycle

<https://developer.android.com/codelabs/basic-android-kotlin-compose-activity-lifecycle>

![](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-activity-lifecycle/img/468988518c270b38_856.png)

启动：
1. onCreate Called
2. onStart Called
3. onResume Called

按home：
1. onPause Called
2. onStop Called

恢复：
1. onRestart Called
2. onStart Called
3. onResume Called

按返回：
1. onPause Called
2. onStop Called
3. onDestroy Called

直接杀进程，没有onDestroy

旋转设备：
1. onPause Called
2. onStop Called
3. onDestroy Called
4. onCreate Called
5. onStart Called
6. onResume Called

onPause() 中运行的任何代码都会阻止其他内容的显示，因此请保持 onPause() 中的代码轻量级。例如，如果有电话打入， onPause() 中的代码可能会延迟来电通知。

使用 rememberSaveable 可以保存数据，在onDestroy后台也可以保存，但是杀了进程也是会丢失

## [unit4-unscramble](unit4-unscramble) ViewModel


