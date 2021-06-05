中间件应用：
中间件包括：缓存、消息队列、RPC框架等

##一：缓存中间件
###一：redis
####1：redis的基本数据类型以及应用场景
1：String类型
（1）概念：
是最基本的数据类型；
（2）命令
（3）应用场景
--（1）：文章阅读量统计：将文章id作为key值，将阅读量作为value值


##二：消息中间件
###一：rabbitMq
####1：rabbitMq配置死信队列
1：概念：

2：目的：
为了保证订单业务的消息数据不丢失，需要使用到RabbitMQ的死信队列机制，当消息消费发生异常时，将消息投入死信队列中
3：死信队列的生命周期：
（1）业务消息被投入到业务队列中
（2）消费者消费业务队列中的消息，由于处理过程中发生异常，于是进行nck或reject操作
（3）被nck或reject的消息被放到死信交换机中
（4）死信交换机将消息放到对应的死信队列中
（5）消费者消费死信队列里的消息
4：应用：
对于一些比较重要的业务队列，我们不希望消息消费异常就被丢弃时我们就可以采用死信队列

####2：通过死信队列实现延迟队列
1：概念：延时队列中的元素是希望在指定时间得到和处理的

2：使用场景
（1）订单在十分钟内未支付自动取消
（2）新创建的店铺在十天内没上传商品就自动发消息提醒
（3）账单在一周内未支付则自动结算
（4）用户发起退款，三天之内未处理通知相关运营人员

3：实现：
我们可以通过mq中的ttl属性去实现：ttl是指一个消息或一个队列中的所有消息的最大存活时间，当一条消息被设置了ttl后未在规定时间内被消费就会成为死信。

（1）设置单条消息ttl
AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
builder.expiration("6000");
AMQP.BasicProperties properties = builder.build();
channel.basicPublish(exchangeName, routingKey, mandatory, properties, "msg body".getBytes());

（2）设置某个队列中所有消息ttl
Map<String, Object> args = new HashMap<String, Object>();
args.put("x-message-ttl", 6000);
channel.queueDeclare(queueName, durable, exclusive, autoDelete, args);

但这两种方式是有区别的，如果设置了队列的TTL属性，那么一旦消息过期，就会被队列丢弃，而第一种方式，消息即使过期，也不一定会被马上丢弃，因为消息是否过期是在即将投递到消费者之前判定的，
如果当前队列有严重的消息积压情况，则已过期的消息也许还能存活较长时间。



