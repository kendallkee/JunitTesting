package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnit#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream <Arguments> argumentsForAddPositive() {
		return Stream.of(
	            Arguments.arguments(2, 4, 6, false),
	            Arguments.arguments(5, 3, 8, false),
	            Arguments.arguments(0, 0, 0, true),
	            Arguments.arguments(-1, 1, 0, true), 
	            Arguments.arguments(1, -1, 0, true),
	            Arguments.arguments(10, 10, 20, false)
	            );
	}
	//Step 2-1 create a method annotated with @Test.
	 @Test
	    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
	        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	        //Add some more for testing purposes
	        assertThat(testDemo.addPositive(3, 2)).isEqualTo(5);
	        assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
	        assertThat(testDemo.addPositive(26, 3)).isEqualTo(17);
	    }
	 
	 //Step 3 Create Junit Test using Test and ParameterizedTest
	 @Test
	    void assertThatMultiplicationIsCorrect() {
	        assertThat(testDemo.multiply(3, 4)).isEqualTo(12);
	        assertThat(testDemo.multiply(-1, -1)).isEqualTo(1);
	        assertThat(testDemo.multiply(-1, 2)).isEqualTo(-2);
	    }

	    @ParameterizedTest
	    @MethodSource("multiplicationArguments")
	    void assertThatMultiplicationIsCorrectParameterized(int a, int b, int expected) {
	        assertThat(testDemo.multiply(a, b)).isEqualTo(expected);
	    }

	    static Stream <Arguments> multiplicationArguments() {
	        return Stream.of(
	                Arguments.arguments(3, 4, 12),
	                Arguments.arguments(-1, -1, 1),
	                Arguments.arguments(-1, 2, -2),
	                Arguments.arguments(0, 5, 0),
	                Arguments.arguments(100, 100, 10000)
	            );
	        }
	    
	    //Step 4
	    @Test
	    void assertThatNumberSquaredIsCorrect() {
	        TestDemo mockDemo = spy(testDemo);
	        doReturn(5).when(mockDemo).getRandomInt();

	        int result = mockDemo.randomNumberSquared();

	        assertThat(result).isEqualTo(25);
	    }

}
