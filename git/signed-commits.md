# Signing Commits

Before following these instructions, please ensure:
* you have a GitHub account with a verified email
* you have access to the email associated with that GitHub account (note that this may be something like "...@users.noreply.github.com" if your email is set to private)

## Instructions:

1. Download GPG command line tools
(https://www.gnupg.org/download/)
2. Generate a key pair
    1. run this command: `gpg --full-generate-key`
    2. specify RSA as the encryption you want
    3. specify 4096 as the size
    4. include a length of time
    5. confirm
    6. enter your name
    7. enter your email (associated with GitHub account)
    8. enter a comment (optional)
    9. add a password
3. run this command: `gpg --list-secret-keys --keyid-format=long`
4. copy the key id you'd like to use
5. run this command: `gpg --armor --export <YOUR_SECRET_KEY_ID>`
6. Copy the long form of the key, including -----BEGIN PGP PUBLIC KEY BLOCK----- and -----END PGP PUBLIC KEY BLOCK-----
7. Go to your settings on github and add the GPG key
8. Configure Git
    1. run this command: `git config --global user.signingkey <YOUR_SECRET_KEY_ID>`
    2. run this command: `git config --global user.email <YOUR_EMAIL>`
9. On future commits, use `git commit -S -m "signed commit message"` to sign your commits
10. enjoy your verified status