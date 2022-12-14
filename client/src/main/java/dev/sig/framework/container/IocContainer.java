package dev.sig.framework.container;

import dev.sig.framework.utils.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IocContainer {

    private static final IocContainer instance = new IocContainer();

    private final Map<String, Object> beans = new ConcurrentHashMap<>();

    private IocContainer(){
        final String packagePath = "dev.sig";
        Class<?>[] allClasses = ClassUtils.getClasses(packagePath);

        // TODO allClasses 롤링하며 어노테이션별로 새로운 맵객체에 저장
    }

    public static IocContainer getInstance(){
        return instance;
    }

    public void init() {
        AnnoPriority.getPriorityAsc()
                    .forEach(instance::initByReflect);
    }

    private void initByReflect(AnnoPriority anno){
        Method m = ReflectionUtils.findMethod(
                getClass(), "init".concat(anno.name()));

        m.setAccessible(true);
        ReflectionUtils.invokeMethod(m, this);
    }

    private enum AnnoPriority {
        Config(1), Bean(2), Component(2), Service(3), Client(4), Facade(5), Autowired(6),
        ;

        private final int priority;

        AnnoPriority(int priority) {
            this.priority = priority;
        }

        public int getPriority(){
            return priority;
        }

        public static List<AnnoPriority> getPriorityAsc(){
            return Stream.of(values())
                    .sorted(Comparator.comparing(AnnoPriority::getPriority))
                    .collect(Collectors.toList());
        }
    }

    private void initConfig(){
        System.out.println("Called initConfig");
    }

    private void initBean(){
        System.out.println("Called initBean");
    }

    private void initService(){
        System.out.println("Called initService");
    }

    private void initClient(){
        System.out.println("Called initClient");
    }

    private void initFacade(){
        System.out.println("Called initFacade");
    }

    private void initAutowired(){
        System.out.println("Called initAutowired");
    }

    private void initComponent(){
        System.out.println("Called initComponent");
    }

}
