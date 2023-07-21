package pk.sandbox;


import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface EmployeeMapper {

    EmployeeDTO mapx2(Employee employee);

    List<EmployeeDTO> mapx3(List<Employee> employees);

   // Set<EmployeeDTO> mapx(Set<Employee> employees);

    //Map<String, EmployeeDTO> mapx(Map<String, Employee> idEmployeeMap);
}
