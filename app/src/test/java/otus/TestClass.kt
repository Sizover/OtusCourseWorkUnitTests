package otus

import dev.shreyaspatil.foodium.data.repository.Resource
import dev.shreyaspatil.foodium.model.Post
import dev.shreyaspatil.foodium.model.State
import dev.shreyaspatil.foodium.ui.main.adapter.PostListAdapter
import dev.shreyaspatil.foodium.utils.isNight
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockedStatic
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import java.time.Instant
import java.util.*
import org.mockito.Mockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(JUnit4::class)

class TestClass() {
    @Test
    fun errorStateTest(){
        val service: State<Post> = State.error("TEST")
        Assert.assertEquals(service.isLoading(), false)
        Assert.assertEquals(service.isFailed(), true)
        Assert.assertEquals(service.isSuccessful(), false)
    }

    @Test
    fun loadingStateTest(){
        val service: State<Post> = State.loading()
        Assert.assertEquals(service.isLoading(), true)
        Assert.assertEquals(service.isFailed(), false)
        Assert.assertEquals(service.isSuccessful(), false)
    }
    @Test
    fun successStateTest(){
        val service: State<Post> = State.success(Post())
        Assert.assertEquals(service.isLoading(), false)
        Assert.assertEquals(service.isFailed(), false)
        Assert.assertEquals(service.isSuccessful(), true)
    }

    //тесты опеределения времени суток также при желании можно дополнить иными граничными значениями или каким-то провайдером/фабрикой массива пар <час суток, ожидаемый результат>
    @Test
    fun isNightTrue() {
        val calendar: Calendar = Mockito.mock(Calendar::class.java)
        Mockito.`when`(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(6)
        assert(isNight())
    }
    fun isNightFalse() {
        val calendar: Calendar = Mockito.mock(Calendar::class.java)
        Mockito.`when`(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(7)
        assert(isNight())
    }
}