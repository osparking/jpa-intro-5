package space.bum.sboot.batch;

import javax.sql.DataSource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;

public class ProxyDataSourceInterceptor implements MethodInterceptor {
  private final DataSource dataSource;

  public ProxyDataSourceInterceptor(final DataSource dataSource) {
    this.dataSource = ProxyDataSourceBuilder.create(dataSource)
        .name("Batch-Insert-Logger")
        .asJson().countQuery().logQueryToSysOut().build();
  }

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    return null;
  }

}
