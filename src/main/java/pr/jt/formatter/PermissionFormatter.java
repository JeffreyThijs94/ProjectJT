package pr.jt.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import pr.jt.model.Permission;
import pr.jt.repository.PermissionRepository;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PermissionFormatter implements Formatter<Permission> {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission parse(final String text, final Locale locale) throws ParseException {
        if (text != null && !text.isEmpty())
            return permissionRepository.findOne(new Long(text));
        else return null;
    }

    public String print(final Permission object, final Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }
}
