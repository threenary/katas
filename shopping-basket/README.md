## Shopping Basket Kata

### Scenario 1 - Add items to shopping basket

Given I add 2 units of "The Hobbit" to my shopping basket
And I add 5 units of "Breaking Bad"
When I check the content of my shopping basket
Then it should contain the following information:
- Creation date (of the shopping basket)
- 2 x The Hobbit   // 2 x 5 = 10
- 5 x Breaking Bad // 5 x 7 = 35
- Total: 45

**Acceptance criteria:**
- Shopping basket should be created when the first product is added.
- Shopping basket should be persisted (In-memory, DB later)
- Each user should have her own shopping basket.

Products available (in-memory repository):
- Books 
   - 10001: Lord of the Rings - 10
   - 10002: The Hobbit - 5     
- DVDs
   - 20001: Game of Thrones - 9 
   - 20110: Breaking Bad - 7

```    
    public class ShoppingBasketService {
    
        public void addItem(UserID userId, ProductID productId, int quantity) { }

        public <?> basketFor(UserID userId) { }
    
    }    
```

### Scenario 2 - Logging
- Log items added to shopping cart on the console: 
    * [BASKET CREATED]: Created[<"YYYY-07-12">], User[<ID>]
    * [ITEM ADDED TO SHOPPING CART]: Added[<"YYYY-07-12">], User[<ID>], Product[ID], Quantity[<N>], Price[<12>]
