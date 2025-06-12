import { useState } from 'preact/hooks'

export function Registro({ onBack }) {
  const [regUsername, setRegUsername] = useState('')
  const [regEmail, setRegEmail] = useState('')
  const [regPassword, setRegPassword] = useState('')
  const [regPassword2, setRegPassword2] = useState('')
  const [regError, setRegError] = useState('')

  const handleRegister = (e) => {
    e.preventDefault()
    if (regPassword !== regPassword2) {
      setRegError('Las contraseñas no coinciden')
      return
    }
    setRegError('')
    alert(`Usuario: ${regUsername}\nEmail: ${regEmail}\nContraseña: ${regPassword}`)
    // Aquí puedes enviar los datos al backend
  }

  return (
    <form class="login-form" onSubmit={handleRegister}>
      <div class="login-logo">
        <svg width="140" height="140" viewBox="0 0 140 140">
          <circle cx="70" cy="50" r="50" fill="#fff" />
          <polygon points="70,70 100,140 40,140" fill="#fff" />
          <circle cx="70" cy="50" r="20" fill="#00aeef" />
        </svg>
      </div>
      <label class="login-label">USUARIO</label>
      <input
        class="login-input"
        type="text"
        value={regUsername}
        onInput={e => setRegUsername(e.target.value)}
        required
      />
      <label class="login-label">EMAIL</label>
      <input
        class="login-input"
        type="email"
        value={regEmail}
        onInput={e => setRegEmail(e.target.value)}
        required
      />
      <label class="login-label">CONTRASEÑA</label>
      <input
        class="login-input"
        type="password"
        value={regPassword}
        onInput={e => setRegPassword(e.target.value)}
        required
      />
      <label class="login-label">CONFIRMAR CONTRASEÑA</label>
      <input
        class="login-input"
        type="password"
        value={regPassword2}
        onInput={e => setRegPassword2(e.target.value)}
        required
      />
      {regError && (
        <div style={{ color: 'red', marginBottom: '10px', fontWeight: 'bold' }}>
          {regError}
        </div>
      )}
      <button class="login-btn" type="submit">
        CREAR CUENTA
      </button>
      <button class="crear-cuenta-btn" type="button" onClick={onBack}>
        Volver
      </button>
    </form>
  )
}