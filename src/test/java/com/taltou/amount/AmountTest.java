package com.taltou.amount;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AmountTest {

    @Test
    public void
    test_two_instances_containing_same_amount() {
        Amount thousand = new Amount(100);
        Amount anotherThousand = new Amount(100);

        assertThat(thousand, is(equalTo(anotherThousand)));
    }

    @Test public void
    test_different_instances_containing_different_amount() {
        Amount hundred_and_twenty = new Amount(120);
        Amount hundred_and_fifty = new Amount(150);

        assertThat(hundred_and_twenty, is(not(equalTo(hundred_and_fifty))));
    }

    @Test public void
    test_initialise_an_amount() {
        assertThat(new Amount(2000), is(equalTo(Amount.newAmount(2000))));
    }

    @Test public void
    test_sum_up_the_amounts() {
        Amount two_thousand = Amount.newAmount(2000);
        Amount one_thousand = Amount.newAmount(1000);
        Amount three_thousand = Amount.newAmount(3000);

        assertThat(three_thousand, is(equalTo(one_thousand.addUp(two_thousand))));
    }

    @Test public void
    test_an_amount_is_greater_than_other_one() {
        Amount two_thousand = Amount.newAmount(10);
        Amount one_thousand = Amount.newAmount(5);

        assertThat(two_thousand.isGreaterThan(one_thousand), is(true));
    }

    @Test public void
    test_an_amount_is_not_greater_than_other_one() {
        Amount two_thousand = Amount.newAmount(10);
        Amount one_thousand = Amount.newAmount(5);

        assertThat(one_thousand.isGreaterThan(two_thousand), is(false));
    }

    @Test public void
    test_return_the_absolute_value() {
        Amount minusTen = Amount.newAmount(-10);

        assertThat(Amount.newAmount(10), is(equalTo(minusTen.absoluteValue())));
    }

    @Test public void
    test_return_the_negative_value() {
        Amount ten = Amount.newAmount(10);

        assertThat(Amount.newAmount(-10), is(equalTo(ten.subtract())));
    }

    @Test public void
    test_return_money_representation() {
        Amount oneThousand = Amount.newAmount(2000);

        assertThat("2000,00", is(equalTo(oneThousand.computeMoneyFormat())));
    }

}
