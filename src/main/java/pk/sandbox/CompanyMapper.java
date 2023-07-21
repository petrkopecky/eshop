package pk.sandbox;


import org.mapstruct.Mapper;

@Mapper(uses = EmployeeMapper.class)
public interface CompanyMapper {

    CompanyDTO mapx1(Company company);
}
