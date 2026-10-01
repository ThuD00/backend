package c25.bookstore.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import c25.bookstore.domain.AppUser;
import c25.bookstore.domain.AppUserRepository;

//used by spring security to authenticate and authorize user
//hakee käyttäjän UserRepositoryn kautta tietokannasta ja muuttaa sen 
//Spring Securityn ymmärtämään UserDetails-muotoon
@Service 
public class UserDetailServiceImpl implements UserDetailsService {
  private final AppUserRepository repository;

  public UserDetailServiceImpl(AppUserRepository userRepository) {
    this.repository = userRepository;
  }

  @Override 
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser curruser = repository.findByUsername(username);
    UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
                      AuthorityUtils.createAuthorityList(curruser.getRole()));
    return user;
  }
}
