package tmp;

import com.tecotalk.proxy.Order;

public class OrderResponse {
    private final Long id;

    public OrderResponse(Long id) {
        this.id = id;
    }

    public OrderResponse(Order order) {
        this.id = order.getId();
    }

    public Long getId() {
        return id;
    }
}
