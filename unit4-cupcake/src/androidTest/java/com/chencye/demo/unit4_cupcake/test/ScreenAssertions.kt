package com.chencye.demo.unit4_cupcake.test

import androidx.navigation.NavController
import org.junit.Assert.assertEquals

// 将名为 assertCurrentRouteName() 的扩展函数添加到 NavController 类
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)

}