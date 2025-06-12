import { useState } from 'preact/hooks'
import './app.css'
import { Registro } from './Registro'

export function App() {
  const [usuario, setUsuario] = useState('')
  const [contrasena, setContrasena] = useState('')
  const [capsLock, setCapsLock] = useState(false)
  const [showRegister, setShowRegister] = useState(false)

  const handleSubmit = (e) => {
    e.preventDefault()
    alert(`Usuario: ${usuario}\nContraseña: ${contrasena}`)
  }

  const handlePasswordKeyUp = (e) => {
    setCapsLock(e.getModifierState && e.getModifierState('CapsLock'))
  }

  return (
    <div class="login-bg">
      {!showRegister ? (
        <>
          <form class="login-form" onSubmit={handleSubmit}>
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
              value={usuario}
              onInput={(e) => setUsuario(e.target.value)}
              required
            />
            <label class="login-label">CONTRASEÑA</label>
            <input
              class="login-input"
              type="password"
              value={contrasena}
              onInput={(e) => setContrasena(e.target.value)}
              onKeyUp={handlePasswordKeyUp}
              required
            />
            {capsLock && (
              <div
                style={{
                  color: 'red',
                  marginBottom: '10px',
                  fontWeight: 'bold',
                }}
              >
                ¡Bloq Mayús está activado!
              </div>
            )}
            <button class="login-btn" type="submit">
              INGRESAR
            </button>
          </form>
          <button
            class="crear-cuenta-btn"
            type="button"
            onClick={() => setShowRegister(true)}
          >
            Crear Cuenta
          </button>
        </>
      ) : (
        <Registro onBack={() => setShowRegister(false)} />
      )}
    </div>
  )
}
