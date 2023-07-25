package pk.mapperDto;

import org.mapstruct.Mapper;
import pk.entity.Role;
import pk.modelDto.RoleDto;

import java.util.List;

@Mapper(uses = UserMapper.class)
public interface RoleMapper {
    RoleDto RoleToRoleDto(Role Role);
    Role RoleDtoToRole(RoleDto RoleDto);

    List<RoleDto> RolesToRolesDto(List<Role> Role);
    List<Role> RolesDtoToRoles( List<RoleDto> RoleDto);
}
